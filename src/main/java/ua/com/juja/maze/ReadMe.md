Лабиринт

Описание:

Требуется разработать и реализовать на языке Java алгоритм генерации двухмерного лабиринта с одним входом и одним выходом. 
В качестве входных и выходных данных используются файлы, пути к котором указываются в качестве аргументов при запуске консольного приложения. 
Первый аргумент это путь до файла в котором указанный данные для генерации лабиринта, 
в качестве второго аргумента используется путь до файла в котором должен быть создан лабиринт.

В входном файле содержится строка содержащая поля разделенные символом “;”. В файле должны быть следующие поля:
длина (абсцисса) лабиринта (целочисленное значение)
ширина (ордината) лабиринта (целочисленное значение)
координата по абсциссе входа в лабиринт (целочисленное значение)
координата по ординате входа в лабиринт (целочисленное значение)
координата по абсциссе выхода из лабиринта (целочисленное значение)
координата по ординате выхода из лабиринта (целочисленное значение)

В выходном файле записывается матрица созданного лабиринта (одна строчка - одна строка матрицы по абсциссе). 
Матрица состоит из набора двух символов: “*” и “-”, где звездочка обозначает стену, а черточка свободное пространство.

Условия:

лабиринт должен иметь только один возможный путь от входа до выхода
в лабиринте должно быть как можно больше “альтернативных путей которые будут уводить в тупик” (тут главное не переборщить)
лабиринт по периметру должен иметь сплошную стену, не считая точки входа и выхода
точки входа и выхода не должны располагаться на углах лабиринта
точка начала координат находится в верхнем левом углу
нумерация ячеек начинается с 0

Пример:

Пример входного файла:

5;6;1;0;2;5

Пример выходного файла:

*-***
*-***
*---*
**-**
**-**
**-**

Дополнительные задания:

Требуется разработать и реализовать на языке Java алгоритм генерации трехмерного лабиринта с одним входом и одним выходом. В качестве входных и выходных данных используются файлы, пути к котором указываются в качестве аргументов при запуске консольного приложения. Первый аргумент это пусть до файла в котором указанный данные для генерации лабиринта, в качестве второго аргумента используется пусть до файла в котором должен быть создан лабиринт.

В входном файле содержится строчка содержащая поля разделенные символом “;”. В файле должны быть следующие поля:
длина (абсцисса) лабиринта (целочисленное значение)
ширина (ордината) лабиринта (целочисленное значение)
высота (аппликата) лабиринта (целочисленное значение)
координата по абсциссе входа в лабиринт (целочисленное значение)
координата по ординате входа в лабиринт (целочисленное значение)
координата по аппликате входа в лабиринт (целочисленное значение)
координата по абсциссе выхода из лабиринта (целочисленное значение)
координата по ординате выхода из лабиринта (целочисленное значение)
координата по аппликате выхода из лабиринта (целочисленное значение)

В выходном файле записываются наборы матриц созданного лабиринта (одна строчка - одна строка матрицы по абсциссе). Первая матрица для аппликаты равной 0, вторая для аппликаты раной 1 и так далее. Матрица состоит из набора двух символов: “*” и “-”, где звездочка обозначает стену, а черточка свободное пространство.

Условия те что и в варианте с двухмерной матрицей.

Пример входного файла:

5;6;3;1;1;0;2;3;2

Пример выходного файла:

*****
*-***
*---*
**-**
**-**
*****
*****
*****
***-*
**-**
*****
*****
*****
*****
*****
**-**
*****
*****