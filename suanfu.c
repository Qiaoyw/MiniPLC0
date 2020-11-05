#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>
//char txt[1002]="i+i+i+i";
char txt[1002];
int max;
char zhan[1002]="#";
int top=1;
int end;


int suan[6][6]={1,-1,-1,1,-1,1,
                1,1,-1,1,-1,1,
                -1,-1,-1,0,-1,2,
				1,1,2,1,2,1,
				1,1,2,1,2,1,
				-1,-1,-1,2,-1,0,
	 };    //0 + ;1 * ;2 (;3 );4 i;5 #

int change(char x){
	if(x=='+') return 0;
	else if(x=='*') return 1;
	else if(x=='(') return 2;
	else if(x==')') return 3;
	else if(x=='i') return 4;
	else return 5;
}

int find(){
	int i=top-1;
	while(zhan[i]=='e') i--;
	return i;
}

void move(){
	int i;
	for(i=end;i<top-1;i++){
		zhan[i]=zhan[i+1]; 
	} 
	zhan[top--]='\0';
}

int up(){
	if(zhan[end]=='i'&&end==top-1) zhan[end]='e';
	else if(end>0&&(end==top-2)&&top>=3&&(zhan[end]=='+'||zhan[end]=='*')&&zhan[end-1]=='e'&&zhan[end+1]=='e'){
		zhan[top-1]='\0';
		zhan[top-2]='\0';
		top=top-2;
	}
	else{
		printf("RE\n");
		return 0; 
	}
	printf("R\n");
	return 1;
}

int begin(){
		char word='\0';
		word=txt[max];
	
		if(change(word)==5){    //无法识别 
			printf("E\n");
			return 2;
		}
		else if(top==0||word=='i'){
			zhan[top++]=word;
			printf("I%c\n",word);
			return 0;
		}
		else{
			end=find();
			int x1=change(zhan[end]);
			int x2=change(word);
			int flag=suan[change(zhan[end])][change(word)];
			if(flag<0){
				zhan[top++]=word;
				printf("I%c\n",word);
				return 0;
			}
			else if(flag==0){
				move();
				return 0;
			}
			else if(flag==1||word=='\r'){
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
				printf("E\n");
				return 2;
			}	
		}
		
		
}

int main(int argc, char *argv[]){
	FILE *fp = fopen(argv[1],"r");
	if(fp==NULL) printf("error"); 
	fgets(txt,999,fp);
	while(txt[max]!='\n'){
		if(begin()==2) break;
		max++;
	}
	fclose(fp);
	return 0;
} 
