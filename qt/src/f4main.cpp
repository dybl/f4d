#include "f4main.h"
#include "ui_f4main.h"

F4Main::F4Main(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::F4Main)
{
    ui->setupUi(this);
}

F4Main::~F4Main()
{
    delete ui;
}
