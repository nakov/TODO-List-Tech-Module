const taskController = require('./../controllers/task');

module.exports = (app) => {
    app.get('/', taskController.index);

	app.get('/create/', taskController.createGet);
	app.post('/create/', taskController.createPost);

	app.get('/delete/:id', taskController.deleteGet);
	app.post('/delete/:id', taskController.deletePost);

    app.get('/edit/:id', taskController.editGet);
    app.post('/edit/:id', taskController.editPost);
};
