# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

set(LOCAL_PATH src/main/cpp/p7zip)

include_directories(${LOCAL_PATH}/C ${LOCAL_PATH}/CPP ${LOCAL_PATH}/CPP/myWindows ${LOCAL_PATH}/CPP/include_windows ${LOCAL_PATH}/CPP/Windows ${LOCAL_PATH}/CPP/Common ${LOCAL_PATH}/CPP/7zip/Common ${LOCAL_PATH}/CPP/7zip/UI/Agent ${LOCAL_PATH}/CPP/7zip/UI/FileManager)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DANDROID_NDK -fexceptions -DNDEBUG -D_REENTRANT -DENV_UNIX -DEXTERNAL_CODECS -DUNICODE -D_UNICODE -DUNIX_USE_WIN_FILE")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -DANDROID_NDK -fexceptions -DNDEBUG -D_REENTRANT -DENV_UNIX -DEXTERNAL_CODECS -DUNICODE -D_UNICODE -DUNIX_USE_WIN_FILE")
file(GLOB my_c_path ${LOCAL_PATH}/C/*.c)
file(GLOB my_archive_common_path src/main/cpp/p7zip/CPP/7zip/Archive/Common/*.cpp)
file(GLOB my_archive_7z_path src/main/cpp/p7zip/CPP/7zip/Archive/7z/*.cpp)
file(GLOB my_archive_cab_path src/main/cpp/p7zip/CPP/7zip/Archive/Cab/*.cpp)
file(GLOB my_archive_chm_path src/main/cpp/p7zip/CPP/7zip/Archive/Chm/*.cpp)
file(GLOB my_archive_iso_path src/main/cpp/p7zip/CPP/7zip/Archive/Iso/*.cpp)
file(GLOB my_archive_nsis_path src/main/cpp/p7zip/CPP/7zip/Archive/Nsis/*.cpp)
file(GLOB my_archive_rar_path src/main/cpp/p7zip/CPP/7zip/Archive/Rar/*.cpp)
file(GLOB my_archive_tar_path src/main/cpp/p7zip/CPP/7zip/Archive/Tar/*.cpp)
file(GLOB my_archive_udf_path src/main/cpp/p7zip/CPP/7zip/Archive/Udf/*.cpp)
file(GLOB my_archive_vim_path src/main/cpp/p7zip/CPP/7zip/Archive/Wim/*.cpp)
file(GLOB my_archive_zip_path src/main/cpp/p7zip/CPP/7zip/Archive/Zip/*.cpp)
file(GLOB my_7zip_common_path src/main/cpp/p7zip/CPP/7zip/Common/*.cpp)
file(GLOB my_7zip_crypto_path src/main/cpp/p7zip/CPP/7zip/Crypto/*.cpp)
file(GLOB my_7zip_ui_path src/main/cpp/p7zip/CPP/7zip/UI/Console/*.cpp)
file(GLOB my_common_path src/main/cpp/p7zip/CPP/Common/*.cpp)


add_library( # Sets the name of the library.
        7zip

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ${my_c_path}
        ${my_archive_common_path}
        ${my_archive_7z_path}
        ${my_archive_cab_path}
        ${my_archive_chm_path}
        ${my_archive_iso_path}
        ${my_archive_nsis_path}
        ${my_archive_rar_path}
        ${my_archive_tar_path}
        ${my_archive_udf_path}
        ${my_archive_vim_path}
        ${my_archive_zip_path}
        ${my_7zip_common_path}
        ${my_7zip_crypto_path}
        ${my_7zip_ui_path}
        ${my_common_path}
        src/main/cpp/p7zip/CPP/7zip/Archive/ApmHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ArHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ArjHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/Bz2Handler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ComHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/CpioHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/CramfsHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/DeflateProps.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/DmgHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ElfHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ExtHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/FatHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/FlvHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/GptHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/GzHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/HandlerCont.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/HfsHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/IhexHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/LzhHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/LzmaHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/MachoHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/MbrHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/MslzHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/MubHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/NtfsHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/PeHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/PpmdHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/QcowHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/RpmHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/SplitHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/SquashfsHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/SwfHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/UefiHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/VdiHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/VhdHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/VmdkHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/XarHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/XzHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Archive/ZHandler.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Bcj2Coder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Bcj2Register.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BcjCoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BcjRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BitlDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BranchMisc.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BranchRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ByteSwap.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BZip2Crc.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BZip2Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BZip2Encoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/BZip2Register.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/CodecExports.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/CopyCoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/CopyRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Deflate64Register.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/DeflateDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/DeflateEncoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/DeflateRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/DeltaFilter.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ImplodeDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ImplodeHuffmanDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzhDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Lzma2Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Lzma2Encoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Lzma2Register.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzmaDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzmaEncoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzmaRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzmsDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzOutWindow.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/LzxDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/PpmdDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/PpmdEncoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/PpmdRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/PpmdZip.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/QuantumDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Rar1Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Rar2Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Rar3Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Rar3Vm.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/Rar5Decoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/RarCodecsRegister.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ShrinkDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/XpressDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ZDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ZlibDecoder.cpp
        src/main/cpp/p7zip/CPP/7zip/Compress/ZlibEncoder.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/ArchiveCommandLine.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/ArchiveExtractCallback.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/ArchiveName.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/ArchiveOpenCallback.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/Bench.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/DefaultName.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/EnumDirItems.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/Extract.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/ExtractingFilePath.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/HashCalc.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/LoadCodecs.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/OpenArchive.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/PropIDUtils.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/SetProperties.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/SortUtils.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/TempFiles.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/Update.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/UpdateAction.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/UpdateCallback.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/UpdatePair.cpp
        src/main/cpp/p7zip/CPP/7zip/UI/Common/UpdateProduce.cpp
        src/main/cpp/p7zip/CPP/Windows/COM.cpp
        src/main/cpp/p7zip/CPP/Windows/DLL.cpp
        src/main/cpp/p7zip/CPP/Windows/ErrorMsg.cpp
        src/main/cpp/p7zip/CPP/Windows/FileDir.cpp
        src/main/cpp/p7zip/CPP/Windows/FileFind.cpp
        src/main/cpp/p7zip/CPP/Windows/FileIO.cpp
        src/main/cpp/p7zip/CPP/Windows/FileName.cpp
        src/main/cpp/p7zip/CPP/Windows/PropVariantConv.cpp
        src/main/cpp/p7zip/CPP/Windows/PropVariant.cpp
        src/main/cpp/p7zip/CPP/Windows/PropVariantUtils.cpp
        #src/main/cpp/p7zip/CPP/Windows/Registry.cpp
        src/main/cpp/p7zip/CPP/Windows/Synchronization.cpp
        src/main/cpp/p7zip/CPP/Windows/System.cpp
        src/main/cpp/p7zip/CPP/Windows/TimeUtils.cpp
        src/main/cpp/p7zip/CPP/myWindows/myAddExeFlag.cpp
        src/main/cpp/p7zip/CPP/myWindows/mySplitCommandLine.cpp
        src/main/cpp/p7zip/CPP/myWindows/wine_date_and_time.cpp

        src/main/cpp/p7zip/native-lib.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        7zip

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})