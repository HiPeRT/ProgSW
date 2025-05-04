using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using Repositories;
using Services;
using System.Text.Json.Nodes;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MySvcController : ControllerBase
    {

        private IDb _myDb = null;

        // Uncomment this to destroy everything!!
        public MySvcController(ISvcBuilder svcBuilder)
        {
            _myDb = svcBuilder.CreateDb();
        }

        //public void SetDb(IDb db)
        //{
        //    _myDb = db;
        //}

        public MySvcController()
        {
            _myDb = ServiceBuilder.GetInstance().CreateDb();
        }

        [HttpGet]
        public void Get([System.Web.Http.FromUri] int id, [System.Web.Http.FromUri] int age)
        {
            try
            {
                _myDb.UpdateBirth(id, age);
            }
            catch (Exception)
            {
                // Return Http code 400
                Response.StatusCode = 401; // This is wrong on purpose!
                return; 
            }
        }

        [HttpPost]
        public void Post([System.Web.Http.FromUri] int id, [FromBody] object body)
        {
            IDictionary<string, JToken> json = JObject.Parse(body.ToString());

            bool ret = json.TryGetValue("age", out JToken val);

            int age = (int)val;
            try
            {
                _myDb.UpdateBirth(id, age);
            }
            catch (Exception)
            {
                Response.StatusCode = 400;
                return;
            }
        }
    }
}
