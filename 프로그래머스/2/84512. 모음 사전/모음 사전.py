vowels = ['A', 'E', 'I', 'O', 'U'];
answer = 0
found = False

def solution(word):
    
    dfs("", word);
    
    return answer

def dfs(cur, word):
    global answer
    global found
    
    if (found):
        return;
    
    if (len(cur) > 5): 
        return;

    if (word == cur):
        found = True
        return
    
    for i in range(len(vowels)):
        dfs(cur + vowels[i], word)
        
    answer = answer + 1;