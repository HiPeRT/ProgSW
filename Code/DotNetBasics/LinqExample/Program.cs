// Watch out! This example is without the main func!!


var list = new HashSet<MyClass> // List<MyClass>
{
    new MyClass { Id = 0, Payload = "ciao" },
    new MyClass { Id = 1, Payload = "mondo" },
    new MyClass { Id = 2, Payload = "crudele" },
    new MyClass { Id = 3, Payload = "del" },
    new MyClass { Id = 4, Payload = "cavolo" },
};

// 1. Query the list objects with Payload starting with "c" and longer than 5
// This is a nested query
var p = (from y in (from x in list
                   where x.Payload.StartsWith('c')
                   select x)
        where y.Payload.Length >= 5
        select y.Payload)
        .ToArray() // Convert to array (not mandatory! Just as an example)
        .OrderByDescending(z => z.Length); // And order it by its Length descending
foreach (var item in p)
{
    Console.WriteLine(item);
}

// 1.5 Same as before, but not nested
var nonNestedP =  from x in list
                  where x.Payload.StartsWith('c')
                         && x.Payload.Length >= 5
                  select x;

// 2. I need only the "Id" field
var p2 = from y in (from x in list
                    where x.Payload.StartsWith("c")
                    select x)
          where y.Payload.Length >= 5
          select y.Id;

foreach (var item in p2)
     Console.WriteLine($"Found ID {item}");


// 3. Use the FLUENT LINQ interface insetad of the SQL-based
// This API declares a Domain-Specific (sub)Language for querying any IEnumerable
var pFluent = list.Where(x => x.Payload.StartsWith('c') && x.Payload.Length >= 5)
                  .Select(y => y.Payload)
                  .ToArray()
                  .OrderByDescending(z => z.Length)
                  .Select(s => s.ToUpper()); 

foreach (var item in pFluent)
    Console.WriteLine(item);

// Declare inline class
public class MyClass
{
    public string Payload { get; set; } = default!; // Initialize with default type for "string", i.e., "null"

    public int Id { get; set; } = 0;
}


