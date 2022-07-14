function fibonacciSeries(number) {
  let fibonacciNumber = [];
// fobonacci series using for loop
  for (let i = 0; i <= number; i++) {
    if (i == 0) {
      fibonacciNumber[i]=0;
    } else if (i == 1) {
      fibonacciNumber[i]=1;
    } else {
      fibonacciNumber[i] = fibonacciNumber[i - 2] + fibonacciNumber[i - 1];
      
    }
  }


}
console.log(fibonacciSeries(6));
