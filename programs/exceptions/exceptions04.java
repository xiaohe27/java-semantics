public class Main {
  void main(string[] args) {
    int x = 1;
    try { int x = 5; throw x; int y = x/0;}   // division by zero unreachable
    catch(int y) {y = y + 2; print(y," ");}   // new y here, the one declared by catch
    print(x,"\n");
  }
}
// 7 1
