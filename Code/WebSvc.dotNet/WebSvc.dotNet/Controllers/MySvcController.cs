using Microsoft.AspNetCore.Mvc;
using Dto;
using Repositories;
using AutoMapper;
using Model;
using Services;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]
    //[Route("/api/mycontroller")]
    public class MySvcController : ControllerBase
    {
        private readonly ILogger<MySvcController> _logger;
        private readonly IPersonaService _myDb;
        private readonly IMapper _mapper;

        public MySvcController(ILogger<MySvcController> logger, IPersonaService myDb, IMapper mapper)
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
                var p = _mapper.Map<Person>(dto);
                p.Id = id;
                _myDb.UpdateBirth(p);
            }
            catch (Exception)
            {
                Response.StatusCode = 400;
                return;
            }
        }
    }
}
