using Microsoft.AspNetCore.Mvc;
using TestApp.Dto;
using TestApp.Model;
using TestApp.Services;

namespace TestApp.Controllers;

[ApiController]
[Route("[controller]")]
public class WeatherForecastController : ControllerBase
{
    private IWeatherForecastService _service;

    private readonly ILogger<WeatherForecastController> _logger;

    public WeatherForecastController(IWeatherForecastService weatherForecastService, ILogger<WeatherForecastController> logger)
    {
        _logger = logger;
        _service = weatherForecastService;
    }

    [HttpGet(Name = "GetWeatherForecast")]
    public async Task<IEnumerable<WeatherForecastDto>> Get()
    {
        var retval = _service.GetWeatherForecasts();
        _logger.Log(LogLevel.Information, "Hello World");

        return WeatherForecastDto.ToDto(retval);
    }
}
