public class Main {
  void main(string[] args) {
    int x = 1;
    try { x = x + 1; throw x; x = x/0;}     // division by zero unreachable
    catch(int y) {x = y+1;}
    print(x,"\n");
  }
}
// 3
