%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  burger_60.pl  –  AI Sous-Chef (Team 60)
%  Uses Situation Calculus with action stack(X)
%  and knowledge bases KB1.pl / KB2.pl.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% ------------------------------------------------------------------
% 1. Include the knowledge base (change to 'KB2.pl' to test KB2)
% ------------------------------------------------------------------
:- include('KB1.pl').  % KB1 contains constraints like tomato must be above lettuce
%:- include('KB2.pl').  % Uncomment this line if you want to test with KB2

% ------------------------------------------------------------------
% 2. Domain: ingredients
%    - All ingredients that can be stacked in the burger
% ------------------------------------------------------------------

% Define each ingredient
ingredient(bottom_bun).  % Bottom bun is the first ingredient in the burger
ingredient(patty).       % Patty comes next, usually after bottom bun
ingredient(lettuce).     % Lettuce follows the patty
ingredient(cheese).      % Cheese goes after the lettuce
ingredient(pickles).     % Pickles are added next
ingredient(tomato).      % Tomato comes before the top bun
ingredient(top_bun).     % Top bun is the last ingredient

% List of all ingredients, in the correct order
all_ingredients([bottom_bun, patty, lettuce, cheese, pickles, tomato, top_bun]).

% ------------------------------------------------------------------
% 3. Situation representation
%    - s0  represents the initial situation: no ingredients are stacked.
%    - result(Action, S)  represents a new situation after performing Action.
% ------------------------------------------------------------------

% Initial state: no ingredients are stacked
situation(s0).

% Successor states: the state after stacking an ingredient X
% The result of stacking X on top of the burger (represented as result(stack(X), S)) 
% is valid if the ingredient hasn't been stacked already in situation S.
situation(result(stack(X), S)) :-
    situation(S),
    ingredient(X),       % X must be one of the defined ingredients
    \+ stacked(X, S).    % Ingredient X shouldn't already be in the burger in situation S

% ------------------------------------------------------------------
% 4. Fluent: burger(S, ListOfIngredientsFromTopToBottom)
%    - This fluent keeps track of the ingredients in the burger for situation S.
%    - A fluent in Situation Calculus represents how the world changes after actions.
% ------------------------------------------------------------------

% In the initial situation (s0), the burger is empty.
burger(s0, []).

% As ingredients are stacked, the list of ingredients in the burger changes.
% When stacking ingredient X on situation S, we add X to the front of the list.
burger(result(stack(X), S), [X | Rest]) :-
    burger(S, Rest).   % The rest of the ingredients in the burger are listed in Rest

% ------------------------------------------------------------------
% 5. Fluent: stacked(X, S)
%    - This fluent checks if ingredient X has already been stacked in situation S.
% ------------------------------------------------------------------

% Check if ingredient X appears in the burger in situation S
stacked(X, S) :-
    burger(S, List),      % Get the list of ingredients in the burger
    member(X, List).      % Check if X is in the list of ingredients

% ------------------------------------------------------------------
% 6. Helper: index_of/3
%    - This helper predicate finds the index of an ingredient X in a list.
%    - The index represents the position of X in the burger list.
% ------------------------------------------------------------------

% If X is the first element in the list, its index is 0.
index_of([X | _], X, 0).

% If X is not the first element, recursively check the rest of the list.
index_of([_ | T], X, I) :-
    index_of(T, X, I1),     % Recursively check the rest of the list
    I is I1 + 1.            % The index increases by 1 as we go down the list

% ------------------------------------------------------------------
% 7. Check ordering constraints from above/2 in the KB
%    - above(A, B) means that ingredient A must be stacked above ingredient B in the burger.
%    - This function ensures that the constraints from the KB are respected.
% ------------------------------------------------------------------

% This predicate ensures that no stacking violations occur (i.e., the "above" constraint is satisfied)
respects_above_constraints(List) :-
    \+ (
        above(X, Y),              % Find an "above" constraint
        index_of(List, X, IX),    % Find the index of X in the list
        index_of(List, Y, IY),    % Find the index of Y in the list
        IX >= IY                  % If X is not above Y, this is a violation
    ).

% ------------------------------------------------------------------
% 8. Check that the burger is complete and valid
%    - A valid burger should have all ingredients stacked in the correct order.
%    - It must include all 7 ingredients and respect all "above" constraints.
% ------------------------------------------------------------------

valid_burger(List) :-
    % The burger must have exactly all 7 ingredients
    all_ingredients(Ingredients),
    length(List, 7),                % Ensure the burger has exactly 7 ingredients
    msort(List, Sorted),            % Sort the list of ingredients
    msort(Ingredients, Sorted),     % Sort the list of all ingredients
    % The burger must start with the top bun and end with the bottom bun
    List = [top_bun | _],           % Ensure top bun is at the top
    append(_, [bottom_bun], List),  % Ensure bottom bun is at the bottom
    % The burger must satisfy all above/2 constraints
    respects_above_constraints(List).

% ------------------------------------------------------------------
% 9. Final goal: A situation S where the burger is complete and valid
%    - This predicate checks that a valid burger can be achieved in situation S.
% ------------------------------------------------------------------

final_burger(S) :-
    situation(S),               % Ensure S is a valid situation
    burger(S, List),             % Get the list of ingredients in the burger
    valid_burger(List).          % Check if the burger is valid

% ------------------------------------------------------------------
% 10. Iterative Deepening Search using call_with_depth_limit/3
%    - This ensures that we can search for a solution without running into infinite loops.
%    - It deepens the search incrementally until a valid solution is found.
% ------------------------------------------------------------------

% IDS base case: If the search reaches a depth limit and succeeds, we stop
ids(Goal, Limit) :-
    call_with_depth_limit(Goal, Limit, Result),
    number(Result).               % If a valid result is found within the depth limit

% IDS recursive case: If the depth limit is exceeded, increase the limit and try again
ids(Goal, Limit) :-
    call_with_depth_limit(Goal, Limit, Result),
    Result = depth_limit_exceeded,  % If the limit is exceeded, try deeper
    Limit1 is Limit + 1,
    ids(Goal, Limit1).

% ------------------------------------------------------------------
% 11. Public predicate: burgerReady(S)
%     - When S is a variable: find a situation where a valid burger is stacked.
%     - When S is ground: check if that situation represents a valid burger.
% ------------------------------------------------------------------

burgerReady(S) :-
    ids(final_burger(S), 0).    % Use IDS to find a valid burger configuration


