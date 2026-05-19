/**
 * Write your info here
 *
 * @name Omar Mohamed Ali Osman
 * @id 55-6177
 * @tutorialNumber 5
 */

grammar Assignment2;

s returns [int check]
    : seq { $check = $seq.check; }
    |     { $check = 1; }
    ;

seq returns [int check]
    : n=NUM { $check = 1; }
    | n=NUM ',' rest=tail[Integer.parseInt($n.text)] { $check = $rest.check; }
    ;

// tail[prev] parses the rest of the sequence given the previous digit.
// "first" is returned so the caller can compare itself against its right neighbour.
tail[int prev] returns [int check, int first]
    : n=NUM
      {
        $check = 1;
        $first = Integer.parseInt($n.text);
      }
    | n=NUM ',' rest=tail[Integer.parseInt($n.text)]
      {
        int cur = Integer.parseInt($n.text);
        // cur is a strict local max/min iff (cur-prev) and (cur-next) share a sign
        $check = ((cur - $prev) * (cur - $rest.first) > 0) ? $rest.check : 0;
        $first = cur;
      }
    ;

NUM : [0-9]+ ;
WS  : [ \t\r\n]+ -> skip ;
