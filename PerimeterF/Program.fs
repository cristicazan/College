open System

// normal function that computes and returns the perimeter of a square based on the length of the square
let computePerimeter (side: int32) =
    side*4

// recursive function that gets a message that is being written in the conosole, reads the input and if the input is int32 it returns back, otherwise it's calling itself back with the same message
let rec readInputResult (message: string) =
    System.Console.Write(message);
    let input = Console.ReadLine();
    let (ok, number)= System.Int32.TryParse input
    if ok then 
        number
    else
        readInputResult(message)

//main method: gets square side value, computes the perimeter, writes it in console and then finishes the execution
[<EntryPoint>]
let main argv =
    let squareSideLength = readInputResult("Please insert square side length ( int ): ");
    let perimeter = computePerimeter(squareSideLength);
    System.Console.WriteLine(String.Format("Perimeter of a square with side length of {0} is {1}.", squareSideLength, perimeter));
    0 // return an integer exit code