package circles;

class Circle {
    double d, r, x, y, vx, vy;

    public Circle(double d, double x, double y, double vx, double vy) {
        this.d = d;
        this.r = d / 2;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "d=" + d +
                ", r=" + r +
                ", x=" + x +
                ", y=" + y +
                ", vx=" + vx +
                ", vy=" + vy +
                '}';
    }

    public void move(int w, int h) {

        if (this.x < this.r) {
            this.x = this.r;
            this.vx *= -1;
        }

        if (this.x > w - this.r) {
            this.x = w - this.r;
            this.vx *= -1;
        }

        if (this.y < this.r) {
            this.y = this.r;
            this.vy *= -1;
        }

        if (this.y > h - this.r) {
            this.y = h - this.r;
            this.vy *= -1;
        }

        this.x += this.vx;
        this.y += this.vy;

    }

}
