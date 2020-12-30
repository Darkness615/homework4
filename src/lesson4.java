import java.util.Random;
import java.util.Scanner;

public class lesson4
{
    public static void main (String [] args)
    {
        start(3);
    }

        static void start (int size)
        {
        char [][] field=getField(3);
        do
        {
            humanTurn(field);
            draw(field);
            if (ckeFinal(field,'X'))
            {

                break;
            }

            System.out.println();

            handleAIMove(field);
            draw(field);

            if (ckeFinal(field,'O'))
            {

                break;
            }
        } while (true);


    }


    static boolean ckeFinal(char[][] field,char sign)
    {

        if (chekWin2(field,'X'))
        {
            String name= sign == 'X' ? "Игрок" : "Компьютер";
            System.out.printf("%s выиграл!",name);
            return true;
        }
        if (draw(field))
        {
            System.out.println("Ничья!");
            return  true;
        }
        return false;
    }


    static void drawField(char[][] field)
    {
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[i].length; ++j)
            {
                System.out.println(field[i][j]);
            }
        System.out.println();
        }
    }

    static char[][] getField(int size)
    {
        char[][] field =new char[size][size];
        for (int i=0;i<size;i++)
        {
            for (int j=0; j<size; j++)
            {
                field[i][j]=emptySymbol();
            }

        }
        System.out.println();
        return field;
    }

    static boolean draw(char[][] field)
    {
        int moves= field.length * field.length;
        for (int i=0;i < field.length;++i)
        {
            for (int j=0;j < field[i].length;++j)
            {
                if (field[i][j]!=emptySymbol())
                {
                    moves--;
                }
            }
        }
        return false;
    }


    static boolean chekWin2(char[][] field,char sign)
    {
    for (int i = 0; i < 3; i++)
        if ((field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) ||
        (field[0][i] == sign && field[1][i] == sign &&
    field[2][i] == sign))
        return true;
        if ((field[0][0] == sign && field[1][1] == sign && field [2][2] == sign) ||
        (field[2][0] == sign && field[1][1] == sign &&  field[0][2] == sign))
        return true;
    return false;
}



    static boolean chekWin(char[][] field,char sign)
    {
       for (int i=0;i< field.length;i++)
       {
           if (field[i][0] == sign && field[i][1] == sign && field[i][2]==sign)
           {
               return true;
           }
       }

        for (int i=0;i< field.length;i++)
        {
            if (field[0][i]==sign && field[1][i]==sign && field[2][i]==sign)
            {
                return true;
            }
        }
        if (field[0][0]==sign && field[1][1]==sign && field[2][2]==sign)
        {
            return true;
        }

        if (field[0][2]==sign && field[1][1]==sign && field[2][0]==sign)
        {
            return true;
        }

        return false;
    }


    static void handleAIMove(char[][]field)
    {
        Random random=new Random();
        int x;
        int y;
        do
        {
            x= random.nextInt(3);
            y= random.nextInt(3);
        } while (isEmptyCoordinates(field,x,y));
        field[y][x] = 'O';
    }


    static void humanTurn(char[][]field)
    {
        int x, y;
        do {
            System.out.println("Введите ячейку в формате X Y:");
            x = chooseCoordinate('X');
            y = chooseCoordinate('Y');
        } while (isEmptyCoordinates(field,x,y));
        field[y][x] = 'X';
    }


    static int chooseCoordinate (char sign)
    {
        Scanner scanner=new Scanner(System.in);
        int coordinate;
        do
        {
            System.out.printf("Пожалуйста, %s, введитье координату от 1 до 3 %n",sign);
            coordinate=scanner.nextInt()-1;
        }while (coordinate<0||coordinate>2);
        return coordinate;
    }



    static boolean isEmptyCoordinates (char [][] field,int x,int y)
    {
        return field[x][y]!='-';
    }

    static void doPlayerMove(char[][] field)
    {
        int x,y;
        do
        {
            System.out.println("Пожалуйста выберите коориднату X и Y ");
            x=chooseCoordinate('X');
            y=chooseCoordinate('Y');
        }while (field[x][y]!='-');
        field[x][y]='X';
    }





  static char emptySymbol()
  {
      return  '-';
  }

}
