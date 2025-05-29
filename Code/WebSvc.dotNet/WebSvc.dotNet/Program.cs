using Helpers;
using Repositories;

namespace WebSvc.dotNet
{
    public class Program
    {
        private static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();

            builder.Services.AddAutoMapper(cfg => { cfg.AddProfile<AutoMapperProfile>(); });

            if (builder.Environment.EnvironmentName == "Local")
            {
                builder.Services.AddSingleton<IDb, InMemoryDb>();
            }
            else
                builder.Services.AddSingleton<IDb, MongoDb>();


            var app = builder.Build();

            // Configure the HTTP request pip

            app.UseHttpsRedirection();

            app.UseAuthorization();

            app.MapControllers();

            app.Run();
        }
    }
}