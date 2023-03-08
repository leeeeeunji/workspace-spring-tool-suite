/*
학생객체를 생성하는 class 작성
*/
class Student {
	constructor(id, name, kor, eng, math) {
		this.id = id;
 		this.name = name;
 		this.kor = kor;
 		this.eng = eng;
 		this.math = math;
 		this.tot = 0;
 		this.avg = 0.0;
	}
	calculateTot() {
		this.tot = this.kor + this.eng + this.math;
	}
	calculateAvg() {
		this.avg = this.tot / 3;
	}
	toString() {
		return "[" + this.id + "] " + this.name + ", " + this.kor + ", " + this.eng + ", " + this.math + ", " + this.tot + ", " + this.avg;
	}
	
	
	
}

