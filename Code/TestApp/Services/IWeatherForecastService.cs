using TestApp.Model;

namespace TestApp.Services
{
    public interface IWeatherForecastService
    {
        WeatherForecast[] GetWeatherForecasts();
    }
}
