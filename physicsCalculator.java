class PhysicsCalculator {
    /// multiply, works nice ///
    int multiply(int x, int y){
        return(x * y);
    }
    
    int multiplyTest1 = this.multiply(12,8);
    int multiplyTest1Exp = 96;
    int multiplyTest2 = this.multiply(-5,4);
    int multiplyTest2Exp = -20;

    /// square ///
    int square(int x){
        return this.multiply(x,x); 
    }

    int squareTest1 = this.square(3);
    int squareTest1Exp = 9;
    int squareTest2 = this.square(0);
    int squareTest2Exp = 0;

    /// Newton's Second Law ///
    int newton2(int mass, int accel){
        return this.multiply(mass,accel); 
    }
    
    int newton2Test1 = this.newton2(5,2);
    int newton2Test1Exp = 10;
    int newton2Test2 = this.newton2(100,-3);
    int newton2Test2Exp = -300;

    /// Mass Energy Eq ///
    int massEnergyEq(int mass, int c){
        return this.multiply(mass,this.square(c)); 
    }

    int massEnergyEqTest1 = this.massEnergyEq(10,512);
    int massEnergyEqTest1Exp = 2621440;
    int massEnergyEqTest2 = this.massEnergyEq(5,100);
    int massEnergyEqTest2Exp = 50000;
}