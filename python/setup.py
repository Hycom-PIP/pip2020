from distutils.core import setup

setup(
    name = 'learning',
    version = '1.0.0',
    description= 'Moduł umożliwiający uczenie się',
    author = '',
    packages=['learning'],
    install_requires = ['numpy', 'pandas ', 'tensorflow', 'sklearn'],
    license='MIT'
)