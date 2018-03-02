grammar infixtoposfix;

prog: expr+
    ;
expr: fator op=('*'|'/')  expr 
    |  fator op=('+'|'-') expr 
    | fator
    ;
fator: NEWLINE
     | INT
     | ID
     ;
INT: [0-9]+;
ID: [a-zA-Z][a-zA-Z0-9]*;
NEWLINE: [\r\n]+;
WS: ['(' | ')' | \t]+ -> skip;