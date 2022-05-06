# Tensorflow 1 Interface

<!-- badges: start -->
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Twitter](https://img.shields.io/twitter/follow/Icy_BioImaging?style=social)](https://twitter.com/Icy_BioImaging)
[![Image.sc forum](https://img.shields.io/badge/discourse-forum-brightgreen.svg?style=flat)](https://forum.image.sc/tag/icy)
<!-- badges: end -->

This library contains the functions to convert TensorFlow 1 tensors into Icy sequences and viceversa. This library is compatible with TensorFlow versions up to 1.15. This repository also proposes this functionalities as a plugin for the [bioimage analysis software Icy](http://icy.bioimageanalysis.org/), which was developed by members or former members of the [Biological Image Analysis unit at Institut Pasteur](https://research.pasteur.fr/en/team/bioimage-analysis/). This plugin is licensed under GPL3 license.

Icy is developed and maintained by [Biological Image Analysis unit at Institut Pasteur](https://research.pasteur.fr/en/team/bioimage-analysis/). The [source code of Icy](https://gitlab.pasteur.fr/bia/icy) is also licensed under a GPL3 license.

## Plugin description

<!-- Short description of goals of package, with descriptive links to the documentation website --> 

Convert Images and sequences into Tensors easier with this library plugin. Version compatible with TensorFlow up to 1.15

A more detailed user documentation can be found on the TensorFlow 1 Interface documentation page on the Icy website: http://icy.bioimageanalysis.org/plugin/tensorflow-1-interface/               

## Installation instructions

For end-users, refer to the documentation on the Icy website on [how to install an Icy plugin](http://icy.bioimageanalysis.org/tutorial/how-to-install-an-icy-plugin/).      

For developers, see our [Contributing guidelines](https://gitlab.pasteur.fr/bia/icy/-/blob/master/CONTRIBUTING.md) and [Code of Conduct](https://gitlab.pasteur.fr/bia/icy/-/blob/master/CODE-OF-CONDUCT.md).      

<!--  Here we should have some explanations on how to fork this repo (for an example see https://gitlab.pasteur.fr/bia/wellPlateReader). Add any info related to Maven etc. How the project is build (for an example see https://gitlab.pasteur.fr/bia/wellPlateReader). Any additional setup required (authentication tokens, etc).  -->


## Main functions and usage

<!-- list main functions, explain architecture, classname, give info on how to get started with the plugin. If applicable, how the package compares to other similar packages and/or how it relates to other packages -->

Classname: `plugins.danyfel80.tensorflow.v1.TensorFlow1Interface`

To convert images and sequences into tensors you can use the class `org.bioimageanalysis.icy.tensorflow.v1.tensor.TensorBuilder`.

To do the inverse process use the respective classes:

- `org.bioimageanalysis.icy.tensorflow.v1.tensor.IcyBufferedImageBuilder`
- `org.bioimageanalysis.icy.tensorflow.v1.tensor.SequenceBuilder`

## Citation 

Please cite this plugins as follows:          

There is no associated publication for this plugin.

http://icy.bioimageanalysis.org    

## Author(s)      

Daniel Felipe Gonzalez Obando [dgonzale@pasteur.fr](mailto:dgonzale@pasteur.fr)


## Additional information

