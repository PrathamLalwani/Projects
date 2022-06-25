const express = require('express');

const path = require('path');
const rootDir = require('../util/path');

const router = express.Router();

router.get('/', (req, res, next) => {
  console.log('In the middleware');
  res.render('shop');
});

module.exports = router;
