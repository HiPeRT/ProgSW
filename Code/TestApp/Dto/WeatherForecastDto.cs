using TestApp.Model;

namespace TestApp.Dto
{
    public class WeatherForecastDto
    {
        public WeatherForecastDto(WeatherForecast d)
        {
            // TODO populate fields
            this.Date = d.Date;
        }

        public DateOnly Date { get; set; }

        public int TemperatureC { get; set; }

        public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);

        public string? Summary { get; set; }

        // TODO This breaks Single Responsibility! How do we fix this?
        public static WeatherForecastDto[] ToDto(WeatherForecast[]? models)
        {
            var ret = new List<WeatherForecastDto>();
            foreach(var d in models)
                ret.Add(new WeatherForecastDto(d));

            return ret.ToArray();
        }
    }
}
