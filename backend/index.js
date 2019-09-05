const express = require('express');
const bodyParser = require("body-parser");
const mysql = require('mysql');


const enjoyjakarte = express();
enjoyjakarte.use(express.json());
enjoyjakarte.use(bodyParser.urlencoded({ extended: false }));
enjoyjakarte.listen(process.env.PORT || 3000, function () {
    console.log("server running")
})


const db = mysql.createConnection({
    host: "remotemysql.com",
    user: "QFXAe3BCg7",
    password: "mdPHef9nqv",
    database: "QFXAe3BCg7"
});

db.connect((err) => {
    if (err) throw err;
    console.log("connected");
})

enjoyjakarte.all('/:param', (req, res) => {
    res.set('Access-Control-Allow-Origin', '*')
    res.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    let query;
    switch (req.params.param) {
        case "WisataAir":
            query = `SELECT * FROM destinasi WHERE kategori = 'Wisata Air'`;
            // tslint:disable-next-line: no-shadowed-variable
            db.query(query, (err, data) => {
                if (err) res.status(200).send(err);
                res.send(data);
            });
            break;
        case "WisataKuliner":
            query = `SELECT * FROM destinasi WHERE kategori = 'Wisata Kuliner'`;
            // tslint:disable-next-line: no-shadowed-variable
            db.query(query, (err, data) => {
                if (err) res.status(200).send(err);
                res.send(data);
            });
            break;
        case "WisataBelanja":
            query = `SELECT * FROM destinasi WHERE kategori = 'Wisata Belanja'`;
            // tslint:disable-next-line: no-shadowed-variable
            db.query(query, (err, data) => {
                if (err) res.status(200).send(err);
                res.send(data);
            });
            break;
        case "WisataHiburanEdukasi":
            query = `SELECT * FROM destinasi WHERE kategori = 'Wisata Edukasi Hiburan'`;
            // tslint:disable-next-line: no-shadowed-variable
            db.query(query, (err, data) => {
                if (err) res.status(200).send(err);
                res.send(data);
            });
            break;
        default:
            res.status(404).send("not found")
            break;
    }
})

