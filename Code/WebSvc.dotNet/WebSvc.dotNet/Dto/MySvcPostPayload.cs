using System.ComponentModel.DataAnnotations;
using WebSvc.dotNet.Helpers;

namespace Dto
{
    public class MySvcPostPayload
    {
        [Required]
        [MyAgeValidator(maxVal:100)]
        //[Range(0,100)]
        public string Age { get; set; } = default!;
    }
}
