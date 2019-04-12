#include "f4main.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    F4Main w;
    w.show();

    return a.exec();
}
