package circles;

class Circle {
    double d, r, x, y;

    public Circle(double d, double x, double y) {
        this.d = d;
        this.r = d / 2;
        this.x = x - r;
        this.y = y - r;
    }

    public void move1() {
        this.x++;
        this.y++;
    }

    public void move2() {
        this.x--;
        this.y--;
    }
}
