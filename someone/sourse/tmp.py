import os

def draw(field):
    for i in range(BOARD_SIZE):
        print("|".join(field[i]))


def isValid(field, move_i, move_j):
    return field[move_i][move_j] == '#'
    

def move(field):
    global move_counter
    figures = ['O', 'X']
    print("Pick your move")
    move_i, move_j = map(int, input().split())
    
    if isValid(field, move_i, move_j):
        move_counter += 1
        os.system('cls')
        field[move_i][move_j] = figures[move_counter % 2]
        if check_win(field) == 1:
            print('Do u want to play again (n - no)?')
            if play_again(input()):
                os.system('cls')
                return 'restart'
    else:
        os.system('cls')
        print('Irregular move! Try again')
        


def play_again(feedback):
    if feedback.lower() != 'n':
        return 1
    else:
        print("See ya later!")
        exit()


def check_win(field):
    # Check rows
    for row in field:
        if row[0] != '#' and all(element == row[0] for element in row):
            draw(field)
            print(f'Team {row[0]} won')
            return 1

    # Check columns
    for j in range(BOARD_SIZE):
        column = [field[i][j] for i in range(BOARD_SIZE)]
        if column[0] != '#' and all(element == column[0] for element in column):
            draw(field)
            print(f'Team {column[0]} won')
            return 1

    # Check main diagonal
    diagonal = [field[i][i] for i in range(BOARD_SIZE)]
    if diagonal[0] != '#' and all(element == diagonal[0] for element in diagonal):
        draw(field)
        print(f'Team {diagonal[0]} won')
        return 1

    # Check anti-diagonal
    anti_diagonal = [field[i][BOARD_SIZE - 1 - i] for i in range(BOARD_SIZE)]
    if anti_diagonal[0] != '#' and all(element == anti_diagonal[0] for element in anti_diagonal):
        draw(field)
        print(f'Team {anti_diagonal[0]} won')
        return 1

    if str(field).count('#') == 0:
        print('draw')
        return 1
    return 0

def create_field(size):
    return [['#' for _ in range(size)] for _ in range(size)]


# constantes
BOARD_SIZE = 3
move_counter = 0
game = True
field = create_field(BOARD_SIZE)
os.system('cls')
draw(field)

# game loop
while game:
    current = move(field)

    if current == 'restart':
        field = create_field(BOARD_SIZE)
        move_counter = 0
    
    draw(field)
    