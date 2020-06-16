require('dotenv').config();
const express = require('express');
const app = express();
const cors = require('cors');

const jwt = require('jsonwebtoken');
app.use(cors());
app.use(express.json())

let refreshTokens = [];
app.post('/token', (req, res) => {
    const refreshToken = req.body.token;
    if (refreshToken == null) {
        res.sendStatus(401);
    }
    if (!refreshTokens.includes(refreshToken)) {
        res.sendStatus(403);
    }
    jwt.verify(refreshToken, process.env.REFRESH_TOKEN_SECRET, (err, user) => {
        if (err) return res.sendStatus(403);
        const accessToken = generateAccessToken({ name: user.name })
        res.json({ accessToken });
    })
})

const infos = [
    {
        username: 'user',
        mail: 'quanhui812@gmail.com'
    },
    {
        username: 'newacc',
        mail: 'quanhui81299@gmail.com'
    }
]


app.get('/reset', authenticateToken, (req, res) => {
    infos.map(info => {
        if (info.username === req.user.name) {
            res.json(info);
        }
    })
})

app.delete('/delete', (req, res) => {
    refreshTokens = refreshTokens.filter(token => token !== req.body.token);
    res.sendStatus(204);
})

// app.post('/login', (req, res) => {
//     //Authenticate User 
//     const username = req.body.username;
//     const user = { name: username }

//     const accessToken = generateAccessToken(user);
//     const refreshToken = jwt.sign(user, process.env.REFRESH_TOKEN_SECRET);
//     refreshTokens.push(refreshToken);
//     console.log("user: " + username);
//     console.log(accessToken.length);
//     res.json({ accessToken: accessToken, refreshToken: refreshToken })
// })

app.get('/login', (req, res) => {
    //Authenticate User 
    const username = req.query.username;
    const user = { name: username }
    const accessToken = generateAccessToken(user);
    const refreshToken = jwt.sign(user, process.env.REFRESH_TOKEN_SECRET);
    refreshTokens.push(refreshToken);
    res.json({ accessToken: accessToken, refreshToken: refreshToken })
})

function generateAccessToken(user) {
    return jwt.sign(user, process.env.ACCESS_TOKEN_SECRET, { expiresIn: '5m' });
}


function authenticateToken(req, res, next) {
    const authHeader = req.headers['authorization'];
    const token = authHeader && authHeader.split(' ')[1];
    if (token == null) return res.sendStatus(401);

    jwt.verify(token, process.env.ACCESS_TOKEN_SECRET, (err, user) => {
        if (err) {
            return res.sendStatus(403);
        }
        req.user = user;
        next();
    });
}


app.listen(8082);