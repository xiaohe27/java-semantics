public class Main {
  void main(string[] args) {
    int e = 100;
    try {
      int x = 5;
      if (x >= 0)
        throw x+2;
      print(20);      // should not be printed
    } catch(int e) {
      print(e, " ");   // should print 7
    }
    print(e, " ");     // should print 100
    print(10, "\n");
  }
}
// 7 100 10
