using AutoMapper;
using Dto;
using Model;

namespace Helpers
{
    public class AutoMapperProfile : Profile
    {
        public AutoMapperProfile()
        {
            // Crate mappings

            CreateMap<MySvcPostPayload, Person>()
                .ForMember(d => d.Age, opt => opt.MapFrom(s => int.Parse(s.Age)));
        }
    }
}
