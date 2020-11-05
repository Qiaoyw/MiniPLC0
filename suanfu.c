#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
char txt[1002];
int max;
char zhan[1002];
int top;
int end;


int suan[5][5]={1,-1,-1,1,-1,
                1,1,-1,1,-1,
                -1,-1,-1,0,-1,
				1,1,2,1,2,
				1,1,2,1,2,
	 };    //0 + ;1 * ;2 (;3 );4 i

int change(char x){
	if(x=='+') return 0;
	else if(x=='*') return 1;
	else if(x=='(') return 2;
	else if(x==')') return 3;
	else if(x=='i') return 4;
	else return 5;
}

int find(){
	int i=top;
	while(zhan[i]=='e') i--;
	return i;
}

void move(){
	int i;
	for(i=end;i<top;i++){
		zhan[i]=zhan[i+1]; 
	} 
	zhan[top--]='\0';
}

int up(){
	if(zhan[end]=='i'&&end==top) zhan[end]='e';
	else if(end>0&&(end==top-1)&&top>=2&&(zhan[end]=='+'||zhan[end]=='*')&&zhan[end-1]=='e'&&zhan[end+1]=='e'){
		zhan[top]='\0';
		zhan[top-1]='\0';
		top=top-2;
	}
	else{
		printf("RE");
		return 0; 
	}
	printf("R");
	return 1;
}

int begin(){
		char word=txt[max];
		end=find();
		if(end==5){    //无法识别 
			printf("E");
			return 2;
		}
		int flag=suan[change(zhan[end])][change(word)];
		if(top==0||(flag<0)){
			zhan[top++]=word;
			printf("I%c",word);
			return 0;
		}
		else if(flag=0){
			move();
			return 0;
		}
		else if(flag==1|word=='\r'){
			//规约 
			//E::=E+E|E*E|(E)|i;
			if(up()==1){
				begin();
			}
			else{
				return 2; 
			}
			
		}
		else{        //无法比较优先级 
			printf("E");
			return 2;
		}	
}

int main(int argc, char *argv[]){
	FILE *fp = fopen(argv[1],"r");
	if(fp==NULL) printf("error"); 
	fgets(txt,999,fp);
	char word;
	while(txt[max]!='\n'){
		if(begin()==2) break;
		max++;
	}
	fclose(fp);
	return 0;
} 
