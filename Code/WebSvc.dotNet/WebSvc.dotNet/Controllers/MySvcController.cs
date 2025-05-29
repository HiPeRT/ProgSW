using Microsoft.AspNetCore.Mvc;
using Dto;
using Repositories;
using AutoMapper;
using Model;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MySvcController : ControllerBase
    {
        private readonly ILogger<MySvcController> _logger;
        private readonly IDb _myDb;
        private readonly IMapper _mapper;

        public MySvcController(ILogger<MySvcController> logger, IDb myDb, IMapper mapper)
        {
            _logger = logger;
            _myDb = myDb;
            _mapper = mapper;
        }

        [RequireHttps]
        [HttpPost]
        public void Post([System.Web.Http.FromUri] int id, [FromBody] MySvcPostPayload dto)
        {
            try
            {
                _myDb.UpdateBirth(id, _mapper.Map<Person>(dto));
            }
            catch (Exception)
            {
                Response.StatusCode = 400;
                return;
            }
        }
    }
}
