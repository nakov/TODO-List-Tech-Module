using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace TodoList.Models
{
    public class TodoListDbContext : DbContext
    {
        public virtual IDbSet<Task> Tasks { get; set; }

        public TodoListDbContext() : base("TodoListDb")
        {
        }
    }
}