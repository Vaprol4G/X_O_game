import java.lang.Exception

fun main(args: Array<String>)
{
    val N = 5

    var win_chek = true
    var end_chek = true
    var feld_chek = true

    while (end_chek)
    {
        println("Начинается игра")
        var player = true
        var i_x = 0
        var j_y = 0
        var o_feld : Array<Array<Array<Array<Int>>>> = Array(N) { Array(N) { Array(N) { Array(N) { 1 } } } }

        fun DrawFeld()
        {
            println()
            for (i in 0 until N)
            {
                for (j in 0 until N)
                {
                    for (i2 in 0 until N)
                    {
                        print(" $j| ")
                        for (j2 in 0 until N)
                        {
                            when (o_feld[i][i2][j][j2])
                            {
                                1 -> print("+")
                                0 -> print("O")
                                10 -> print("X")
                                else -> print("-")
                            }
                            print(" ")
                        }
                        print("| ")
                    }
                    println()

                }

                println()
            }
        }

        fun DrawMiniFeld(i: Int, j: Int)
        {
            println("Поле ($i , $j)")
            for (i2 in 0 .. N)
            {
                if (i2 != N)
                {
                    print("$i2 ")
                }


                for (j2 in 0 until N)
                {
                    if (i2 == N)
                    {
                        print("  $j2")
                    }
                    else
                    {
                        when (o_feld[i][j][i2][j2])
                        {
                            1 -> print("+")
                            0 -> print("O")
                            10 -> print("X")
                            else -> print("-")
                        }
                        print("  ")
                    }

                }
                println()
            }
        }

        while (win_chek)
        {
            var un_chek = true
            var x : String
            var y : String

            if (feld_chek)
            {
                DrawFeld()
            }
            else
            {
                DrawMiniFeld(i_x,j_y)
            }
            fun who_win(who : Boolean)
            {
                DrawFeld()
                if(who)
                {
                   println("Игра окончена, победил игрок за 'X'")
                }
                else
                {
                    println("Игра окончена, победил игрок за 'O'")
                }
                win_chek = false
            }

            if (player)
            {
                println("Ход игрока за 'X'")
                while (un_chek)
                {
                    try
                    {
                        print("Укажите координаты клетки в диопазоне от 0 до ")
                        print(N-1)
                        println(" - сначала строка, потом столбец")
                        println("Для изменения отображения поля введите 'min' или 'max'")
                        x = readLine()!!
                        if (x == "max" || x == "Max")
                        {
                            feld_chek = true
                            DrawFeld()
                            continue
                        }
                        if (x == "min" || x == "Min")
                        {
                            feld_chek = false
                            DrawMiniFeld(i_x, j_y)
                            continue
                        }
                        y = readLine()!!

                        if (o_feld[i_x][j_y][x.toInt()][y.toInt()] == 1)
                        {
                            o_feld[i_x][j_y][x.toInt()][y.toInt()] = 10
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][x.toInt()][i] != 10)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(true)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][y.toInt()] != 10)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(true)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][i] != 10)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(true)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][N - (i+1)] != 10)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(true)
                                }
                            }
                            i_x = x.toInt()
                            j_y = y.toInt()
                            un_chek = false
                        }
                        else
                        {
                            println("Эта клетка уже занята")
                        }
                    }
                    catch (e: Exception)
                    {
                        println("Неверный ввод")
                    }
                }
            }
            else
            {
                println("Ход игрока за 'O'")
                while (un_chek)
                {
                    try
                    {
                        print("Укажите координаты клетки в диопазоне от 0 до ")
                        print(N-1)
                        println(" - сначала строка, потом столбец")
                        println("Для изменения отображения поля введите 'min' или 'max'")
                        x = readLine()!!
                        if (x == "max" || x == "Max")
                        {
                            feld_chek = true
                            DrawFeld()
                            continue
                        }
                        if (x == "min" || x == "Min")
                        {
                            feld_chek = false
                            DrawMiniFeld(i_x, j_y)
                            continue
                        }
                        y = readLine()!!
                        if (o_feld[i_x][j_y][x.toInt()][y.toInt()] == 1)
                        {
                            o_feld[i_x][j_y][x.toInt()][y.toInt()] = 0

                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][x.toInt()][i] != 0)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(false)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][y.toInt()] != 0)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(false)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][i] != 0)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(false)
                                }
                            }
                            for (i in 0 until N)
                            {
                                if (o_feld[i_x][j_y][i][N - (i+1)] != 0)
                                {
                                    break
                                }
                                if (i == N-1)
                                {
                                    who_win(false)
                                }
                            }

                            i_x = x.toInt()
                            j_y = y.toInt()
                            un_chek = false
                        }
                        else
                        {
                            println("Эта клетка уже занята")
                        }
                    }
                    catch (e: Exception)
                    {
                        println("Неверный ввод")
                    }
                }
            }


            player = !player
        }


        while (true)
        {
            println("Желаете сыграть ещё раз ? (Y/N)")
            println()
            var end_ans = readLine()
            if (end_ans == "Y" || end_ans == "y") {
                win_chek = true
                break
            } else if (end_ans == "N" || end_ans == "n") {
                end_chek = false
                break
            } else
            {
                println("Неверный ввод, необходимо ввксти 'Y' или 'N'")
            }
        }
    }
}