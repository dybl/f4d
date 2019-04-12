project(face4d)
cmake_minimum_required(VERSION 3.8.12)
set(face4d_VERSION_MAJOR 0)
set(face4d_VERSION_MINOR 3)
set(face4d_VERSION_PATCH 0)
set(face4d_VERSION ${face4d_VERSION_MAJOR}.${face4d_VERSION_MINOR}.${face4d_VERSION_PATCH})

# Find includes in corresponding build directories
set(CMAKE_INCLUDE_CURRENT_DIR ON)
# Instruct CMake to run moc automatically when needed
set(CMAKE_AUTOMOC ON)
# Create code from a list of Qt designer ui files
set(CMAKE_AUTOUIC ON)

# Find the QtWidgets library
find_package(Qt5Widgets CONFIG REQUIRED)

# Populate a CMake variable with the sources

SET(face4d_SOURCES main.cpp f4main.cpp)
SET(face4d_HEADERS f4main.h)
SET(face4d_FORMS f4main.ui)
#SET(face4d_RESOURCES images.qrc)


# Tell CMake to create the face4d executable
add_executable(face4d ${face4d_SOURCES} ${face4d_HEADERS})

# Use the Widgets module from Qt 5
target_link_libraries(face4d Qt5::Widgets)