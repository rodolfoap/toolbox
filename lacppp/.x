gencppapp(){
	mkdir -p $1; cd $1
	cat > CMakeLists.txt <<-EOF
	        cmake_minimum_required (VERSION 2.6)
	        project ($1)
	        add_executable(app $1.cpp)
	EOF
	cat > $1.cpp <<-EOF
	        #include <stdio.h>
	        #include <bits/stdc++.h>
	        #define LOG fprintf(stderr, ">>> %s:%d:%s \n", __FILE__, __LINE__, __func__);
	        class Thing{
	        protected:
	                std::string name;
	        };
	        class Solid :public Thing{
	        public:
	                std::string getName() const;
	                void setName(std::string);
	        };
	        std::string Solid::getName() const{
	                return this->name;
	        }
	        void Solid::setName(std::string name){
	                this->name=name;
	        }
	        int main(){
	                Solid solid;
	                solid.setName("solid0");
	                std::cerr << solid.getName() << std::endl;
	                return 0;
	        }
	EOF
	cat > .x <<-EOF
	        case "$1" in
	        e)
	                vi -p *.cpp
	        ;;
	        '')
	                rm -rf build; mkdir build; cd build; cmake ..; make -j8
	        ;;
	        esac
	EOF
	sed -i 's/        /\t/' CMakeLists.txt $1.cpp .x
}
#
case "$1" in
'')
	echo "Usage: $0 [project]"
;;
*)
	gencppapp $1
	cd $1
	e
;;
esac