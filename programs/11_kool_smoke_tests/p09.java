class a {
  int i, j;

  a() {
    i = 0;
    j = ++i+1;
  }

  int aa() {
    j = ++i+1;
    return j;
  }
  int f() {
    return aa();
  }
  int g() {
    return f();
  }
  int h() {
    return i+j;
  }
}

class b extends a {
  int j, k;

  b() {
    super();
    j = 10;
    k = j+1;
  }

  int aa() {
    return bb();
  }
  int bb() {
    k = ++j+1;
    return k;
  }
  int g() {
    return super.h();
  }
  int h() {
    return g();
  }
}

class c extends b {
  c() {
    i = 100;
    j = i+1;
    k = j+1;
  }

  int aa() {
    return super.aa();
  }
  int bb() {
    return super.bb();
  }
  int g() {
    return i+k*j;
  }
}

class main {
  void p(a o) {
    System.out.print(o.f());
    System.out.print(o.g());
    System.out.println(o.h());
  }
  main(String[] args) {
    p(new a());
    p(new b());
    p(new c());
    System.out.println("Done!");
  }
}

public class p09 {
  public static void main(String[] args) {
    new main(args);
  }
}