using System.ComponentModel.DataAnnotations;

namespace WebSvc.dotNet.Helpers
{
    [AttributeUsage(AttributeTargets.Property)]

    public class MyAgeValidator : ValidationAttribute
    {
        private readonly int _maxVal;

        public MyAgeValidator(int maxVal)
        {
            _maxVal = maxVal;
        }

        public override bool IsValid(object? value)
        {
            if(value == null) return false;

            if (!int.TryParse(value.ToString(), out int v)) return false;

            if (v > _maxVal) return false;

            return true;
        }
    }
}
