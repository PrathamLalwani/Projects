const express = require('express');

const app = express();
const path = require('path');
const adminRoutes = require('./routes/admin');
const shopRoutes = require('./routes/shop');
//setup for view engine
app.set('view engine', 'pug');
app.set('views', 'views');
//setup for reading and parsing JSON
const bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
//access to public files
app.use(express.static(path.join(__dirname, 'public')));
//admin route
app.use('/admin', adminRoutes);
//shop route
app.use(shopRoutes);

app.use((req, res, next) => {
  res.status(404).sendFile(path.join(__dirname, 'views', '404notfound.html'));
});
app.listen(3000);
