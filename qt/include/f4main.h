#ifndef F4MAIN_H
#define F4MAIN_H

#include <QMainWindow>

namespace Ui {
class F4Main;
}

class F4Main : public QMainWindow
{
    Q_OBJECT

public:
    explicit F4Main(QWidget *parent = nullptr);
    ~F4Main();

private:
    Ui::F4Main *ui;
};

#endif // F4MAIN_H
