public class Main {

  void main(string[] args) {
    try {
      1;
      try {
        2;
      } catch(int a) {
        print(2);     // should not print this
      }
      throw 1;
    } catch(int b) {
      print(1,"\n");  // should print this
    }
  }
}

// 1
