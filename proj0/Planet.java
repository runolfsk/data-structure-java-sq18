public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((this.yyPos - p.yyPos) * (this.yyPos - p.yyPos)
                + (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos));
    }

    public double calcForceExertedBy(Planet p) {
        return ((G * this.mass * p.mass) / (calcDistance(p) * calcDistance(p)));
    }

    public double calcForceExertedByX(Planet p) {
        return (calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p));
    }

    public double calcForceExertedByY(Planet p) {
        return (calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p));
    }

    public double calcNetForceExertedByX(Planet[] p_all){
        double sum = 0;
        for(int i = 0; i < p_all.length; i++){
            if (this.equals(p_all[i])){
                continue;
            }
            else{
                sum = sum + calcForceExertedByX(p_all[i]);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p_all){
        double sum = 0;
        for(int i = 0; i < p_all.length; i++){
            if (this.equals(p_all[i])){
                continue;
            }
            else{
                sum = sum + calcForceExertedByY(p_all[i]);
            }
        }
        return sum;
    }

    public void update(double dt, double fX, double fY){
        double a_XX = fX / this.mass;
        double a_YY = fY / this.mass;
        this.xxVel = xxVel + a_XX * dt;
        this.yyVel = yyVel + a_YY * dt;
        this.xxPos = xxPos + xxVel * dt;
        this.yyPos = yyPos + yyVel * dt;
    }

    public void draw() {
        String imagepath = "images/" + this.imgFileName;
        StdDraw.picture(xxPos,yyPos,imagepath);
    }
}
