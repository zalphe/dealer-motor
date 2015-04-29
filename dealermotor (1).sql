-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2014 at 03:03 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dealermotor`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE IF NOT EXISTS `tb_barang` (
  `id_barang` varchar(15) NOT NULL,
  `nama_barang` varchar(30) NOT NULL,
  `warna` varchar(15) NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id_barang`, `nama_barang`, `warna`, `harga`) VALUES
('A-001', 'Mio J', 'Hijau', 12000000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_gudang`
--

CREATE TABLE IF NOT EXISTS `tb_gudang` (
  `id_gudang` varchar(15) NOT NULL,
  `lokasi` varchar(35) NOT NULL,
  `id_pegawai` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_gudang`
--

INSERT INTO `tb_gudang` (`id_gudang`, `lokasi`, `id_pegawai`) VALUES
('g-001', 'Jl Kaliurang', 'WHK-0001');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pegawai`
--

CREATE TABLE IF NOT EXISTS `tb_pegawai` (
  `id_pegawai` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `posisi` varchar(25) NOT NULL,
  `nama_pegawai` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `tgl_lahir` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pegawai`
--

INSERT INTO `tb_pegawai` (`id_pegawai`, `password`, `posisi`, `nama_pegawai`, `alamat`, `no_telp`, `email`, `tgl_lahir`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'Administrator', 'Jl. Administrator', '6285712344321', 'admin@yahoo.com', '19 Desember 1992'),
('MGR-0001', '1d0258c2440a8d19e716292b231e3190', 'Manager', 'Manager1', 'Jl. Manager', '3213', 'manager1@gmail.com', '05 November 1986'),
('MGR-0002', '81dc9bdb52d04dc20036dbd8313ed055', 'Manager', 'afdssd', 'sdfaf', '234234', 'fawf', '01 Juli 1986'),
('SLS-0001', '81dc9bdb52d04dc20036dbd8313ed055', 'Sales', 'asdasd', 'asdas', '12', 'asdasd', '8 Juli 1980'),
('WHK-0001', '81dc9bdb52d04dc20036dbd8313ed055', 'Warehouse Keeper', 'aksjdasd', 'flkasmd		', '3213', 'dfsd', '07 Agustus 1984');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengajuan`
--

CREATE TABLE IF NOT EXISTS `tb_pengajuan` (
  `id_pengajuan` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` varchar(15) NOT NULL,
  `id_gudang` varchar(15) NOT NULL,
  `qty` int(11) NOT NULL,
  `id_pengaju` varchar(15) NOT NULL,
  `id_manager` varchar(15) NOT NULL,
  PRIMARY KEY (`id_pengajuan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tb_pengajuan`
--

INSERT INTO `tb_pengajuan` (`id_pengajuan`, `id_barang`, `id_gudang`, `qty`, `id_pengaju`, `id_manager`) VALUES
(1, 'A-001', 'g-001', 5, 'WHK-0001', 'MGR-0001');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penjualan`
--

CREATE TABLE IF NOT EXISTS `tb_penjualan` (
  `id_penjualan` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` varchar(15) NOT NULL,
  `id_pegawai` varchar(15) NOT NULL,
  `qty` int(11) NOT NULL,
  `total` int(15) NOT NULL,
  `tgl_trans` varchar(15) NOT NULL,
  PRIMARY KEY (`id_penjualan`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `tb_penjualan`
--

INSERT INTO `tb_penjualan` (`id_penjualan`, `id_barang`, `id_pegawai`, `qty`, `total`, `tgl_trans`) VALUES
(1, 'A-001', 'admin', 4, 48000000, '19 May 2014'),
(2, 'A-001', 'admin', 4, 48000000, '19 May 2014'),
(3, 'A-001', 'admin', 2, 24000000, '19 May 2014'),
(4, 'A-001', 'admin', 1, 12000000, '19 May 2014'),
(5, 'A-001', 'admin', 1, 12000000, '19 May 2014'),
(6, 'A-001', 'admin', 1, 12000000, '19 May 2014'),
(7, 'A-001', 'SLS-0001', 4, 48000000, '19 May 2014'),
(8, 'A-001', 'SLS-0001', 4, 48000000, '19 May 2014'),
(9, 'A-001', 'SLS-0001', 7, 84000000, '19 May 2014'),
(10, 'A-001', 'SLS-0001', 4, 48000000, '19 May 2014'),
(11, 'A-001', 'SLS-0001', 5, 60000000, '19 May 2014'),
(12, 'A-001', 'SLS-0001', 10, 120000000, '19 May 2014');

-- --------------------------------------------------------

--
-- Table structure for table `tb_persediaan`
--

CREATE TABLE IF NOT EXISTS `tb_persediaan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` varchar(15) NOT NULL,
  `id_gudang` varchar(15) NOT NULL,
  `stok` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `tb_persediaan`
--

INSERT INTO `tb_persediaan` (`id`, `id_barang`, `id_gudang`, `stok`) VALUES
(5, 'A-001', 'g-001', 90);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
