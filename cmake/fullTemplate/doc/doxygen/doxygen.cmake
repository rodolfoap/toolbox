find_package(Doxygen)

if (DOXYGEN_FOUND)
    add_custom_target(doxygen)
endif ()

function (add_doxygen targetname)
    if (NOT DOXYGEN_FOUND)
        return()
    endif ()

    set(doxydir ${CMAKE_SOURCE_DIR}/doc/doxygen)

    set(outputdir ${CMAKE_SOURCE_DIR}/doc)

    get_property(sourcefiles
        TARGET ${targetname}
        PROPERTY SOURCES)
    foreach (source ${sourcefiles})
        set(source_spaces "${source_spaces} ${source}")
    endforeach ()

    foreach (source ${sourcefiles})
        get_filename_component(source_dir ${source} DIRECTORY)
        set(source_dirs ${source_dirs} ${source_dir})
    endforeach ()

    get_property(includedirs
        TARGET ${targetname}
        PROPERTY INCLUDE_DIRECTORIES)
    list(APPEND includedirs ${source_dirs})
    list(REMOVE_DUPLICATES includedirs)
    foreach (dir ${includedirs})
        set(dir_spaces "${dir_spaces} ${dir}")
    endforeach ()

    foreach (dir ${includedirs})
        file(GLOB headers ${dir}/*.h)
        foreach (h ${headers})
            set(header_spaces "${header_spaces} ${h}")
        endforeach ()
    endforeach ()

    get_property(definitions
        DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}
        PROPERTY COMPILE_DEFINITIONS)
    foreach (def ${definitions})
        set(predef_spaces "${predef_spaces} ${def}")
    endforeach ()

    add_custom_command(
        OUTPUT  ${outputdir}/${targetname}
        COMMAND cmake -E make_directory ${outputdir}/${targetname}
        COMMENT "Creating documentation directory for ${targetname}")

    add_custom_command(
        OUTPUT  ${outputdir}/${targetname}/Doxyfile
        COMMAND ${CMAKE_COMMAND}
                -D "DOXYGEN_TEMPLATE=${doxydir}/Doxyfile.in"
                -D "DOXY_PROJECT_INPUT=${source_spaces} ${header_spaces}"
                -D "DOXY_PROJECT_INCLUDE_DIR=${dir_spaces}"
                -D "DOXY_PROJECT_PREDEFINED=${predef_spaces}"
                -D "DOXY_PROJECT_STRIP_FROM_PATH=${CMAKE_SOURCE_DIR}"
                -D "DOXY_DOCUMENTATION_OUTPUT_PATH=${outputdir}"
                -D "DOXY_PROJECT_NAME=${targetname}"
                -P "${doxydir}/doxygen-script.cmake"
        DEPENDS ${doxydir}/Doxyfile.in
                ${outputdir}/${targetname}
        WORKING_DIRECTORY
                ${outputdir}/${targetname}
        COMMENT "Generating Doxyfile for ${targetname}")

    add_custom_command(
        OUTPUT  ${outputdir}/${targetname}/index.html
        COMMAND ${DOXYGEN_EXECUTABLE}
        DEPENDS ${outputdir}/${targetname}/Doxyfile
        WORKING_DIRECTORY
                ${outputdir}/${targetname}
        COMMENT "Creating HTML documentation for ${targetname}")

    add_custom_target(doxygen-${targetname}
        DEPENDS ${outputdir}/${targetname}/index.html)

    add_dependencies(doxygen
        doxygen-${targetname})

endfunction ()
