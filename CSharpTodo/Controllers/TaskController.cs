using System;
using System.Linq;
using System.Web.Mvc;
using TodoList.Models;

namespace TodoList.Controllers
{
	public class TaskController : Controller
	{
	    [HttpGet]
        [Route("")]
	    public ActionResult Index()
	    {
            using (var db = new TodoListDbContext())
            {
                var tasks = db.Tasks.ToList();
                return View(tasks);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
		{
            return View();
        }

		[HttpPost]
		[Route("create")]
        [ValidateAntiForgeryToken]
		public ActionResult Create(Task task)
		{
            if (ModelState.IsValid)
            {
                using (var db = new TodoListDbContext())
                {
                    db.Tasks.Add(task);
                    db.SaveChanges();
                    return Redirect("/");
                }
            }
            return View();
        }

		[HttpGet]
		[Route("delete/{id}")]
        public ActionResult Delete(int? id)
		{
            using (var db = new TodoListDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task != null)
                {
                    return View(task);
                }
            }
            return Redirect("/");
        }

		[HttpPost]
		[Route("delete/{id}")]
        [ValidateAntiForgeryToken]
		public ActionResult DeleteConfirm(int id)
		{
            using (var db = new TodoListDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task != null)
                {
                    db.Tasks.Remove(task);
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int? id)
        {
            using (var db = new TodoListDbContext())
            {
                var task = db.Tasks.Find(id);
                if (task != null)
                {
                    return View(task);
                }
            }
            return Redirect("/");
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Task task)
        {
            if (!ModelState.IsValid)
            {
                return View(task);
            }

            using (var db = new TodoListDbContext())
            {
                var taskFromDb = db.Tasks.Find(task.Id);
                if (task != null)
                {
                    taskFromDb.Title = task.Title;
                    taskFromDb.Comments = task.Comments;
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }
    }
}