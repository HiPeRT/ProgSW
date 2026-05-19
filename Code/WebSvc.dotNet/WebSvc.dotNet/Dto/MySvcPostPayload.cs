using System.ComponentModel.DataAnnotations;
using WebSvc.dotNet.Helpers;

namespace Dto
{
    public class MySvcPostPayload
    {
        [Required]
        //[Range(0,100)] // This is the supported way to validate the age, but we want to use our custom validator instead.
        [MyAgeValidator(maxVal: 100)]
        public string Age { get; set; } = default!;
    }
}
