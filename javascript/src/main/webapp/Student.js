/*
학생객체를 생성해서 반환해주는 <<< 함수 >>> 작성
*/
function Student(id, name, kor, eng, math) {
 		/*
 		호출 new Student('xxx', 'KIM', 100, 100, 100);
 			=> 1. Object객체 생성({}, new Object())
 			   2. 생성된 Object객체(this)에 속성 추가
 			   3. 생성된 Object객체 반환
 		*/	
 		
 		this.id = id;
 		this.name = name;
 		this.kor = kor;
 		this.eng = eng;
 		this.math = math;
 		this.tot = 0;
 		this.avg = 0.0;
};


/************prototype[case 1]*****************
Student.prototype객체안에 instanace 메쏘드추가(모든 Student객체들이 사용하는 instance메쏘드)
 - Student객체의메쏘드를 호출하면 Student.prototype객체안에서 메쏘드를 찾아서호출한다
**********************************************
Student.prototype.calculateTot =function(){
		this.tot=this.kor+ this.eng + this.math;
};
Student.prototype.calculateAvg =function(){
		this.avg=this.tot/3;
};
Student.prototype.toString =function(){
		return "["+this.id+"]"+this.name+","+this.kor+","+this.eng+","+this.math+","+this.tot+","+this.avg;
};
*/

/************prototype[JSON][case 2]******************/
Student.prototype = {
    		calculateTot : function() {
    			this.tot = this.kor + this.eng + this.math;
    		},
    		calculateAvg : function() {
    			this.avg = this.tot / 3;
    		},
    		toString() { //function 생략가능 -> 익명함수화
    			return "[" + this.id + "] " + this.name + ", " + this.kor + ", " + this.eng + ", " + this.math + ", " + this.tot + ", " + this.avg;
    		}
 };
